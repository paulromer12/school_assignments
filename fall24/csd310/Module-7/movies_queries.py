# Paul Romer, CSD310, Module 7 assignment, September 22 2024

# for employee in employees:
# print(“First Name: {}\n Last Name:{}\n Email:{}\n”.format(employee[0], employee[1], employee[2]))


# Write four queries, in one Python file.The output from your queries should match the example below, including descriptions of output and format.
# The first and second query is to select all the fields for the studio and genre tables.
# The third query is to select the movie names for those movies that have a run time of less than two hours.
# The fourth query is to get a list of film names, and directors grouped by director.

# -- DISPLAYING Studio RECORDS --
# Studio ID:
# Studio Name:

# -- DISPLAYING Genre RECORDS --
# Genre ID: 
# Genre Name: 

# -- DISPLAYING Short Film RECORDS --
# Film Name: 
# Runtime: 

# -- DISPLAYING Director RECORDS in Order --
# Film Name: 
# Director: 

import mysql.connector
from mysql.connector import errorcode 

config = {
    'user': 'root',
    'password': '',
    'host': '127.0.0.1',
    'database': 'movies',
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
# cursor.execute("SELECT * FROM film")
# films = cursor.fetchall()
# print(films)

# First query: Select all fields for the studio table
print("\n-- DISPLAYING Studio RECORDS --")
query_studio = "SELECT * FROM studio"
cursor.execute(query_studio)
studios = cursor.fetchall()
for studio in studios:
    print(f"Studio ID: {studio[0]}\nStudio Name: {studio[1]}\n")

# Second query: Select all fields for the genre table
print("\n-- DISPLAYING Genre RECORDS --")
query_genre = "SELECT * FROM genre"
cursor.execute(query_genre)
genres = cursor.fetchall()
for genre in genres:
    print(f"Genre ID: {genre[0]}\nGenre Name: {genre[1]}\n")

# Third query: Select movie names with runtime less than two hours (120 minutes)
print("\n-- DISPLAYING Short Film RECORDS --")
query_short_films = "SELECT film_name, film_runtime FROM film WHERE film_runtime < 120"
cursor.execute(query_short_films)
short_films = cursor.fetchall()
for film in short_films:
    print(f"Film Name: {film[0]}\nRuntime: {film[1]} minutes\n")

# Fourth query: Select film names and directors, grouped by director
print("\n-- DISPLAYING Director RECORDS in Order --")
query_directors = """
    SELECT film_name, film_director
    FROM film
    GROUP BY film_director, film_name
    ORDER BY film_director
"""
cursor.execute(query_directors)
films_by_director = cursor.fetchall()
for film in films_by_director:
    print(f"Film Name: {film[0]}\nDirector: {film[1]}\n")

# Close the connection
db.close()