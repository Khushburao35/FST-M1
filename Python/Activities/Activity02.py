print("To Exit type any alphabet")

Active = True


while Active:
    val = input("Enter your number: ")
    
    if val.isdigit():
        if(int(val) % 2 == 0):
            print("Its Even");
        else:
            print("Its odd");
    else:
        print("Exiting...")
        break