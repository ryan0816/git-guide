run: Simulator.class
	java Simulator > simulation_output.txt

Human.class: Human.java
	javac Human.java

Simulator.class: Simulator.java Human.java
	javac Simulator.java

clean: 
	rm -f *.class *.txt
