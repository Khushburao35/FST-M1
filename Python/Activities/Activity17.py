import pandas

data = {
  "Usernames": ["Charles", "Admin", "Deku"],
  "Passwords": ["password", "Charl13", "AllMight"]
}

dataframe = pandas.DataFrame(data)

print(dataframe)

dataframe.to_csv("Activity17.csv", index=False)