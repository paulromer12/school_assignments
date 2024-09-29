# Group 5, CSD 310, September 29 2024
# William Renard
# Julie Sakai
# Paul Romer
# Tazmin Somerville


import mysql.connector
from mysql.connector import errorcode 

config = {
    'user': 'root',
    'password': '',
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

def show_films(cursor, title):
    """
    Method to execute an inner join on all tables, iterate over the dataset, and output the results to the terminal.
    """
    # SQL query with INNER JOIN to get employee details
    cursor.execute("""
        SELECT e.employee_first_name AS FirstName, 
               e.employee_last_name AS LastName, 
               p.position_name AS Position, 
               d.department_name AS Department
        FROM Employee
        INNER JOIN Position p ON e.position_id = p.position_id
        INNER JOIN Department d ON e.department_id = d.department_id
    """)

    # Fetch all the results from the query
    films = cursor.fetchall()

    # Print the title of the result set
    print(f"\n== {title} ==")

    # Iterate over the result set and display each record using f-strings
    for film in films:
        print(f"Film Name: {film[0]}\n"
              f"Director: {film[1]}\n"
              f"Genre: {film[2]}\n"
              f"Studio Name: {film[3]}\n")

show_films(cursor, "DISPLAYING FILMS")

# Insert a new film record
cursor.execute("""
    INSERT INTO film (film_name, film_releaseDate, film_runtime, film_director, studio_id, genre_id)
    VALUES ('Inception', 2010, 128, 'Christopher Nolan', 4, 4)
""")
# Commit the changes to the database
db.commit()

# Call show_films again to display films after the insert
show_films(cursor, "DISPLAYING FILMS AFTER INSERTING INCEPTION")

# Update the film "Alien" to be a Horror film
cursor.execute("""
    UPDATE film 
    SET genre_id = 1
    WHERE film_name = 'Alien'
""")
# Commit the changes to the database
db.commit()

# Call show_films again to display films after the update
show_films(cursor, "DISPLAYING FILMS AFTER UPDATING ALIEN TO HORROR")

# Delete the film "Gladiator"
cursor.execute("""
    DELETE FROM film 
    WHERE film_name = 'Gladiator'
""")
# Commit the changes to the database
db.commit()

# Call show_films again to display films after the deletion
show_films(cursor, "DISPLAYING FILMS AFTER DELETING GLADIATOR")

