import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.util.ArrayList

class BaseDeDados(context:Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    internal var co: Context
    var tabsc = ""
    internal var dbw = this.writableDatabase
    internal var dbr = this.readableDatabase

    init {
        co = context
    }

    override fun onCreate(db:SQLiteDatabase) {}
    override fun onUpgrade(db:SQLiteDatabase, oldVersion:Int, newVersion:Int) {
    }

    override fun onDowngrade(db:SQLiteDatabase, oldVersion:Int,newVersion:Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    fun cria_tabelas(bd:SQLiteDatabase) {
        tabsc = ("CREATE TABLE pessoas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT," +
                "email TEXT)")
        try  {
            bd.execSQL(tabsc)
            Log.i("Tabelas", "As tabelas foram criadas")
        } catch (e:Exception) {
            Log.i("Tabelas", "As tabelas já existem")
        }
    }

    fun apa_tabelas(bd: SQLiteDatabase) {
        tabsc = "drop TABLE pessoas"
        try {
            bd.execSQL(tabsc)
            Log.i("Tabelas", "As tabelas foram apagadas")
        } catch (e:Exception) {
            Log.i("Tabelas", "As tabelas n˜ao foram apagadas")
        }
    }

    fun ins_pessoa(bd: SQLiteDatabase) {
        tabsc = "select id from pessoas where nome = 'Paulo Tomé'"
        val res = bd.rawQuery(tabsc, null)
        if (res.count == 0) {
            tabsc = "insert into pessoas(nome,email) values('Paulo Tomé', 'ptome@estv.ipv.pt')"
            bd.execSQL(tabsc)
            tabsc = "insert into pessoas(nome,email) values('Antonio Joaquim', 'aj@estv.ipv.pt')"
            bd.execSQL(tabsc)
        } else {
            Log.i("Tabelas", "Já existem dados")
        }
    }

    fun ins_pessoa_lg(bd: SQLiteDatabase, nome: String, email: String) {
        tabsc = "insert into pessoas (nome, email) values ('$nome', '$email')"
        bd.execSQL(tabsc)
    }

    fun todos_pessoas(bd: SQLiteDatabase): ArrayList<String> {
        val array_list = ArrayList<String>()
        val res = bd.rawQuery("select * from pessoas", null)
        res.moveToFirst()
        while (res.isAfterLast() === false) {
            array_list.add(
                res.getInt(res.getColumnIndex("id")).toString() + " - " +
                res.getString(res.getColumnIndex("nome")) + " - " +
                res.getString(res.getColumnIndex("email"))
            )
            res.moveToNext()
        }
        return array_list
    }

    fun del_pessoa(bd: SQLiteDatabase, id: Int): Boolean {
        val res = bd.delete("pessoas","id = ?", arrayOf(id.toString()))
        return res != -1
    }

    fun get_pessoa_by_email(bd: SQLiteDatabase, email: String): Array<String>? {
        tabsc = "select * from pessoas where email = '$email'"
        val res = bd.rawQuery(tabsc, null)
        res.moveToFirst()
        return if (res.count > 0) {
            arrayOf(
                res.getInt(res.getColumnIndex("id")).toString(),
                res.getString(res.getColumnIndex("nome")),
                res.getString(res.getColumnIndex("email"))
            )
        } else {
            null
        }
    }

    fun update_pessoa(bd: SQLiteDatabase, id: Int, nome: String, email: String): Boolean {
        val values = ContentValues()
        values.put("nome", nome)
        values.put("email", email)

        val res = bd.update("pessoas", values, "id = ?", arrayOf(id.toString()))

        return res != -1
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "pdm.db"
    }
}
