FROM mcr.microsoft.com/vscode/devcontainers/java:11

RUN cd /usr/lib && \
    wget -q https://github.com/JetBrains/kotlin/releases/download/v1.4.10/kotlin-compiler-1.4.10.zip && \
    unzip kotlin-compiler-*.zip && \
    rm kotlin-compiler-*.zip && \
    rm -f kotlinc/bin/*.bat

ENV PATH $PATH:/usr/lib/kotlinc/bin

CMD ["kotlinc"]
