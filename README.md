# Rate My Place of Worship


Step to Run

1) To run the backend service 
   1) Execute the command `bin/setup` to create the database
   2) Execute the command `./gradlew clean bootRun --args='--spring.profiles.active=local' ` to run the service in a local environment
      1) This will seed the database with a few places of worship, from my local area in Reading
2) To run the web app execute the command `cd webapp`
   1) execute the command `npm install`
   2) execute the command `npm start`
3) I have seeded the application with some data for you to play around with . On the search page the location input accepts postcodes or towns, I would recommend using post codes for search. And editing the distance
4) If you select a place of worship from the search screen, then it will take you to a details page for the place of worship. initially it will all be set to 0. if you go and submit a review, then the scores will be updated
