# avaj-launcher

## Description
First project of the Java projects arc. Implementation of a simple Java program according to a given class diagram written in UML.


## Installation 

1. Clone the repository:
```bash
 git clone https://github.com/tlouro-c/ajav_launcher
```

2. Go inside project's directory
```bash
 cd ajav_launcher
```

## Usage

1. Compile
```bash
find * -name "*.java" > sources.txt
javac @sources.txt
```

2. Create **scenario.txt**
	The first line of the file contains a positive integer number. This number represents the
	number of times the simulation is run. In our case, this will be the number of times a
	weather change is triggered.
	Each following line describes an aircraft that will be part of the simulation, with this
	format: TYPE NAME LONGITUDE LATITUDE HEIGHT.

3. Run
```bash
java -cp src/main/java tc.tlouro_c.simulator.Simulator scenario.txt
```

