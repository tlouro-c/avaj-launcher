# avaj-launcher

## Description
This project is part of the Java projects arc and involves creating a simple simulation program using Java. The program models aircraft and their behavior in response to weather changes, following a provided UML class diagram. The simulation runs based on input from a configuration file (```scenario.txt```), where aircraft are described and their interactions with weather conditions are simulated.

![![Uml Diagram](avaj_uml.png)]

## Installation 

1. Clone the repository:
```bash
 git clone https://github.com/tlouro-c/ajav_launcher
```

2. Navigate to the project directory:

```bash
 cd ajav_launcher
```

## Usage

1. Compile the program:
```bash
find * -name "*.java" > sources.txt
javac @sources.txt
```

2. Create the ```scenario.txt``` file:

	The scenario.txt file defines the simulation parameters, including how many times the weather changes, and the aircraft involved. The structure is as follows:


	- The first line contains a single positive integer, which specifies the number of times the simulation runs (i.e., how many times the weather will change).

	- Each subsequent line describes an aircraft to be included in the simulation. The format is:
	```
	TYPE NAME LONGITUDE LATITUDE HEIGHT
	```
	Where:

	- TYPE is the type of the aircraft (e.g., JetPlane, Helicopter, Baloon).
	- NAME is the unique identifier for the aircraft.
	- LONGITUDE, LATITUDE, and HEIGHT are integers representing the starting coordinates and altitude of the aircraft. The altitude (height) should range between 0 and 100.

	Example of a ```scenario.txt``` file:

	```
	5
	JetPlane J1 45 36 85
	Helicopter H1 22 45 90
	Baloon B1 12 18 50
	JetPlane J2 30 22 75
	Baloon B2 5 10 45
	```
	In this example:

	- The simulation will run 5 times.
	- Five aircraft are defined: two JetPlanes, one Helicopter, and two Balloons with their respective coordinates and altitudes.

4. Run the simulation:
```bash
java -cp src/main/java tc.tlouro_c.simulator.Simulator scenario.txt
```

After running the simulation, the output will be displayed, showing how the aircraft react to different weather conditions based on their types and initial positions.

## Output Example

```
Tower says: Baloon#B1(1) registered to weather tower.
Tower says: Baloon#B2(2) registered to weather tower.
Tower says: JetPlane#J1(3) registered to weather tower.
Tower says: Helicopter#H1(4) registered to weather tower.

Simulation 1
Baloon#B1(1): I'm afraid we might fall with all this snow... (LONGITUDE=2, LATITUDE=3, HEIGHT=5)
Baloon#B2(2): I'm afraid we might fall with all this snow... (LONGITUDE=1, LATITUDE=8, HEIGHT=51)
JetPlane#J1(3): Eventually we will land if this snows continues... (LONGITUDE=23, LATITUDE=44, HEIGHT=25)
Helicopter#H1(4): I'm freezing, turn on AC please... (LONGITUDE=654, LATITUDE=33, HEIGHT=8)

Simulation 2
Baloon#B1(1): I'm afraid we might fall with all this snow... (LONGITUDE=2, LATITUDE=3, HEIGHT=0)
Tower says: Baloon#B1(1) unregistered to weather tower.
Baloon#B2(2): Rain, rain, rain go away, let the sun come out and all the children say... (LONGITUDE=1, LATITUDE=8, HEIGHT=46)
JetPlane#J1(3): Going crazy with this fog... (LONGITUDE=23, LATITUDE=45, HEIGHT=25)
Helicopter#H1(4): Sun... All Of The Lights! (LONGITUDE=664, LATITUDE=33, HEIGHT=10)

Simulation 3
Baloon#B2(2): Rain, rain, rain go away, let the sun come out and all the children say... (LONGITUDE=1, LATITUDE=8, HEIGHT=41)
JetPlane#J1(3): Eventually we will land if this snows continues... (LONGITUDE=23, LATITUDE=45, HEIGHT=18)
Helicopter#H1(4): Sun... All Of The Lights! (LONGITUDE=674, LATITUDE=33, HEIGHT=12)

Simulation 4
Baloon#B2(2): And the weather so breezy. Man, why can't life always be this easy? (LONGITUDE=3, LATITUDE=8, HEIGHT=45)
JetPlane#J1(3): Eventually we will land if this snows continues... (LONGITUDE=23, LATITUDE=45, HEIGHT=11)
Helicopter#H1(4): Sun... All Of The Lights! (LONGITUDE=684, LATITUDE=33, HEIGHT=14)

Simulation 5
Baloon#B2(2): I'm afraid we might fall with all this snow... (LONGITUDE=3, LATITUDE=8, HEIGHT=30)
JetPlane#J1(3): Going crazy with this fog... (LONGITUDE=23, LATITUDE=46, HEIGHT=11)
Helicopter#H1(4): Rain... Again... But on the heli... (LONGITUDE=689, LATITUDE=33, HEIGHT=14)
```

