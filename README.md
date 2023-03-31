# cryptojacking-util
This project is used for cross-cutting concerns of Cryptojackingtrap solution. 
For now it includes two distinct parts:

# Test file search util
This part of the project, provides a user-friendly text file search utility that facilitate searching text inside 
one or multiple file. This tool is presented to validating the detector correct behaviour for  known cryptocurrency 
listener file and malware monitoring file output. This part of code is used from 
https://github.com/qwerky/File-Search

# Memory access test
This part is a simple Java main file to make a memory read access and read a known 
hex data called MARK data. This program is used to test the Cryprojackingtrap-monitoring 
project's correctness. By executing the default main class it reads a simple hex content from memory that is 
"0123456789abcdef" and we expect to see this 
mark content in
monitoring module output log.
