	
from os import name
import pandas
dataframe = pandas.read_csv('employees.csv')
print(dataframe["Name"])