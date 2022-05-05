import pandas
dataframe = pandas.read_csv('../resources\employees.csv')
print(dataframe)
print(dataframe["Name"][4])