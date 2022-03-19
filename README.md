# EEngine
A simple component-based code-based engine using Java Swing

EEngine is a one day project and shouldn't be used in a serious way due to instability and lacking performance.<br>
It's structure is heavily influenced by the one of the <a href="https://unity.com/">Unity Engine</a>.

<h2>How To Use</h2>
<h3>Main</h3>
To instantiate new GameObjects at start the main function should be used.<br>
Instantiated GameObjects get automatically added to the game and get initialized the next frame after instantiation.

<h3>GameObject</h3>
GameObjects are used to tie components together.<br>
Do <b>NOT</b> implement any game-logic in GameObjects, components should be used for this.

<h3>Components</h3>
Components are the logic of a GameObject.<br>
They can be coupled together to result in various behaviours.<br>
<h4>Functions</h4>
Start: Is only once initialized on start<br>
Update: Gets called every frame

<h3>IVisualize Interface</h3>
IVisualize is a interface for components to get rendered by the game.<br>
It's only function is called "visualize" and has the parameters of (<a href="https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html">Graphics</a>) g and (<a href="https://en.wikipedia.org/wiki/Vector_(mathematics_and_physics)">Vector</a>) camera offset
