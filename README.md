# portfolioManagmentSystem
stock portfolio management system
person class

so far i've completeed the person class basicly what the constructor does is pull user information out of a mysql database and makes objects out of them
since the constructore has a try catch this means that when creating the object in a diffrent class will also require a try catch, which you would need a mthod to do, i dont want to creae a method everytime i create an object so i made a static mathod that handles the exeption and creates the object in any place in the project.

/im not shure that this was the right way to go about fixing this problem but ut was the best i could come up with./

stcckapi class

The object of this class takes a stock ticker symbole and stores the information from that stock, it does this by getting the stock data using an http call and retrieving the data 
its not perfect yet but im still working on it.

As for the tickers themselves im implemetning a fill search that allowes the user to input something close or even exactly  ticker they are looking for and return a bunch of options instead of having a predefined list of options, this gives the user a lot more options.



