echo "Warning ! The diag.png file must be generated in tmp/src otherwise please edit this script according to your modification"
#sleep 2
echo "Compiling Prototypev3.java..."
javac Prototypev3.java
echo "Compilation done"
echo "Launching Executor.java with the inputs.txt file in arguments..."
java Executor.java ../inputs.txt
echo "Creation of outputs files in tries folder..."
echo "Treatement of outputs files by the python script ShowDatasV3.py..."
python ShowDatasV3.py
echo "Process Done!"


