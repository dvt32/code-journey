# https://classroom.udacity.com/courses/ud036

import turtle

def draw_square():
    window = turtle.Screen()
    window.bgcolor("red")
    
    brad = turtle.Turtle()
    brad.shape("circle")
    brad.color("cyan")
    brad.speed(5)
    
    brad.forward(100)
    brad.right(90)
    brad.forward(100)
    brad.right(90)
    brad.forward(100)
    brad.right(90)
    brad.forward(100)

    debra = turtle.Turtle()
    debra.shape("triangle")
    debra.color("green")
    debra.speed(5)
    debra.circle(100)

    angie = turtle.Turtle()
    angie.shape("arrow")
    angie.color("blue")
    angie.forward(100)
    angie.right(90)
    angie.forward(100)
    angie.right(135)
    angie.forward(130)

    window.exitonclick()

draw_square()
