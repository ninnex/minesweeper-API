# Minesweeper-API

I made the rest-API using Java Spring framework. I'm not a front-end developer, but, I made the client side using ReactJS

# Repos

* Back-end : https://github.com/ninnex/minesweeper-API
* Front-end: https://github.com/ninnex/minesweeper-react-client

# Rest-Api Documentation

* http://168.138.140.243:8080/swagger-ui.html#!/minesweeper-controller/getBoardUsingPOST


I used some integer codes to identify every type of cell:

* 0 : 0 mines around
* 1 : 1 mines around
* 2 : 2 mines around
* 3 : 3 mines around
* 4 : 4 mines around
* 5 : 5 mines around
* 6 : 6 mines around
* 7 : 7 mines around
* 8 : 8 mines around
* 9 : Hide cell
* 10: Mine
* 11: Flag (green case in this case)

To put a flag (green 11 code) use double-click.

You can save the current game using the Save button and then you can load it using the Load button

# Play the game

You can use the url the following in order to play the game

*  http://168.138.140.243:8080/

I miss some features like set parameters like number of columns, rows or mines, multi-users and a lot of UI improvements because I had to fullfill other personal commitments. I will add it when I have another free time.

Rows and columns are set on 10. Mines are set on 10 too.

I really enjoyed making this test. Thank for the opportunity :)







