import pandas
dataframe = pandas.read_excel("../resources/employees.xlsx", sheet_name="Sheet1")
print(dataframe)
print(dataframe["Name"])