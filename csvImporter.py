import pandas as pd
import pymongo as mongo
import pymongo.mongo_client as cliente

# Entramos en mongo a traves del puerto que sea
client = cliente.MongoClient('mongodb://localhost:27017/')
# Elegimos la base de datos
db = client['gestamp']
# Elegimos la coleccion
collection = db['pruebas']

# Leemos el fichero csv
df = pd.read_csv("./files/sales.csv")
final_df = df.sort_values('OrderID', ascending=False)


dictDeDatos = {}
arrayTemporal = []

for row in final_df.itertuples():


    collection.insert(row)
    # metemos todos los datos en un array temporal
    #arrayTemporal.append({ "Region":row.Region, "Country":row.Country, "ItemType":row.ItemType, "SalesChannel":row.SalesChannel, "OrderPriority":row.OrderPriority, "OrderDate":row.OrderDate,
     #                  """         "OrderID":row.OrderID,""" "ShipDate":row.ShipDate, "UnitsSold":row.UnitsSold, "UnitPrice":row.UnitPrice, "UnitCost":row.UnitCost,
      #                         "TotalRevenue":row.TotalRevenue, "TotalCost":row.TotalCost, "TotalProfit":row.TotalProfit})

    # insertamos el documento
    #collection.insert_one(dictDeDatos)
