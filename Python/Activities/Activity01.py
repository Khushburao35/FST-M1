age = input("Enter your value: ")

from datetime import date
  
# creating the date object of today's date
todays_date = date.today()
  
# printing todays date
print("Year when you will be 100 : ",todays_date.year+100-int(age))