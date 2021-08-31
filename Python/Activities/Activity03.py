# Get the players names
player1 = input("What is Player 1's name? ")
player2 = input("What is Player 2's name? ")
 
# Get the users choices
player1_answer = input(player1 + ", do you want to choose rock, paper or scissors? ").lower()
player2_answer = input(player2 + ", do you want to choose rock, paper or scissors? ").lower()

ans = player1_answer + player2_answer

if (player1_answer == player2_answer):
    print("Its a tie");
else:
    result = {
        'rockpaper':player2+' - Paper win',
            'rockscissors':player1+' - Rock win',
            'paperrock':player1+' - Paper win',
            'paperscissors':player2+' - Scissors win',
            'scissorsrock':player2+' - Rock win',
            'scissorspaper':player1+' - Scissors win'
            }
    print(result[ans]);