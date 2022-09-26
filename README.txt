Model:
-For the model part I modified moveShape, changeColor, resizeShape, removeShape methods to changes  shapes info based on the name of the shape. Before I implement it in a way that you can only for example move the shape by passing in that object to modify its information. Now you can just pass in the name of the shape you want to modify.
-Also modified the snapshot Method. Now I will store the information about the current album(a list of shapes) into a list when user called the snapshot method.
-Added a clone method in both rectangle and oval class, this is mainly to solve of problem of reference. We can now add the shapes into a list without altering the information of 
-Added a shapeFactory class, this class will produce shapes like rectangle or oval based on user input from the txt file.
-Added a new method called commandTxtCommands. It takes in an txt file, and hands it to a helper class called txtFileProcessor which converts the txt file into a list of Commands, then, pass that list to a class called commandExecutor. It then runs the commands in the file and returns an instances of model that contains all of the information like the snapshots, IDs, and description for the snapshot. These information will be used to generate views based on user request.

View:
-Graphical view: this view is achieved by using Swing. I constructed this view using three panels. Top panel includes ID and descriptions for the snapshots. Center panel is the draw panel, that will draw out shapes in the snapshot. Bottom panel is where all the button is at.
-Web view: this view is achieved	by using html markup and SVG. It will render the data that is in the model and produce a html file that display all of the snapshots.

Controller:
-I implemented one controller that will initialize a view baed on user request. For the graphical view the controller is the listener that listen to all user input(click of a button) and it will react upon that click. For example if user clicked next, then the view will display the next snapshot.

Entry(PhotoAlbumMain):
-This is the entry point of the program. It takes in command line arguments and run the program with the information given.
