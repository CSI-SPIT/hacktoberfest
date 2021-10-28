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

from tabulate import tabulate
print("==== Auction ====")
print("Loading data...")

# The file contains data in the following format:
# PlayerID,Name,Team,BasePrice
file = open('data/auction_players.csv','r')
lines = file.readlines()

playerList = []

for line in lines:
  row = line.split(",")
  item = {
    'name': row[1],
    'id': row[0],
    'team': row[2],
    'base_price': row[3],
    'highest_bid':0,
    'party_id':0
  }
  playerList.append(item)

for i in playerList:
  i["highest_bid"] = input("Enter the highest bid(in millions) for player:"+i["name"]+"\n")
  i["party_id"] = input("Enter the team id of the corresponding auction party:\n")

print("All the players are auctioned..")
choice=1
while choice!=0:
  choice=input("Enter the ID of the auction party whose list of players you want to query or (ENTER 0 to EXIT): ")
  if choice == "0":
    break
  table=[]
  for p in playerList:
    if(p["party_id"]==choice):
      datalist=[p["name"],p["team"],p["highest_bid"]+",000,000",p["id"]]
      table.append(datalist)

  if not table:
    print("No players bought by team #"+choice)
  else:
    print("\nPlayers bought by team #"+choice+":")
    print(tabulate(table,headers=["Player Name","Team Name","Highest Bid Price","Player ID"]))
    print()

# TODO: Implement actual auction logic once the file is getting read.