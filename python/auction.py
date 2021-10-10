'''
    This mini project involves building a basic IPL auction management system. 
    More and more issues will be added as it is updated.
    The auction software should allow:
    - Reading list of auctioned players from a file.
    - There are a total of 4 parties participating in the auction.
    - The software should show the list of players one at a time and ask
      for the highest bid price (in millions) along with the ID of the auction party.
    - Once all players are auctioned, it should allow the user to query the list of players bought by any party.
'''

print("==== Auction ====")
print("Loading data...")

# The file contains data in the following format:
# PlayerID,Name,Team,BasePrice
file = open('data/auction_players.csv','w')
lines = file.readlines()

playerList = []

for line in lines:
  row = line.split(",")
  item = {
    'name': line[0],
    'id': line[1],
    'team': line[2],
    'base_price': line[3],
  }
  playerList.append(item)

# TODO: Implement actual auction logic once the file is getting read.