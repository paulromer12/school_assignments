# Group 5, Milestone 3, CSD310
# William Renard
# Julie Sakai
# Paul Romer
# Tazmin Somerville 

import mysql.connector
from mysql.connector import errorcode 

config = {
    'user': 'root',
    'password': 'Your Password',
    'host': '127.0.0.1',
    'database': 'bacchus',
    'raise_on_warnings': True,
}

try:
    db = mysql.connector.connect(**config)
    print("\n Database user {} connected to MySQL on host {} with database {}".format(config['user'], config['host'], config['database']))
    input("\n Press any key to continue...")

except mysql.connector.Error as err:
    if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
        print("The supplied username or password are invalid")
    elif err.errno == errorcode.ER_BAD_DB_ERROR:
        print("The specified database does not exist")
    else:
        print(err)


cursor = db.cursor()




# Close the cursor and database connection
cursor.close()
db.close()