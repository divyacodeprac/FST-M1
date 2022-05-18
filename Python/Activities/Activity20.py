import pandas as pd

dataframe=pd.read_excel("sample1.xlsx")
print("Number of rows and colums",dataframe.shape)
print("Data in email column ony")
print(dataframe["Email"])
print("Sorted data:")
dataframe.sort_values('FirstName')
print(dataframe["FirstName"])