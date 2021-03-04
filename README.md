# Bluetooth Serial Controller

A robust bluetooth serial controller to display accelerometer data, CAN data, SD card logs, live graphs and remote shutdown the car

## Data format

The initialization happens with the following 2 bytes. Which give and effective 'reset' command.
| Op-Code		| Function		|
| ------------- 	| ------------- 	|
| s			| SHUTDOWN		|
| g			| GO			|

Every data packet is sent over as 2 bytes.
The first byte is the op-code and the second byte is the data.
The data is usually interpreted as an 8 bit unsigned integer.

| Op-Code		| Data			| Function 	|
| ------------- 	| ------------- 	| -------------	|
| f			| uint8			| Forward	|
| b			| uint8			| Backward	|
| l			| uint8			| Left		|
| r			| uint8			| Right		|

