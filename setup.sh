#!bin/bash
echo "Installing dependencies for Connections Game..."

mkdir -p lib/
cd lib/

# Gson 2.10.1 (stable)
if [ ! -f "gson-2.10.1.jar" ]; then
    echo "Downloading Gson 2.10.1 ..."
    wget https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar
fi

echo "Dependencies are ready"
echo "Compilation: javac -cp lib/gson-2.10.1.jar src/main/java/**/*/.java"