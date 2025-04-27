// server/models/reviewModel.js
const { MongoClient } = require('mongodb');

// MongoDB connection setup
const url = process.env.MONGO_URI;
const dbName = 'mit_connect';

async function postReview(username, review) {
  try {
    const client = await MongoClient.connect(url);
    const db = client.db(dbName);
    const reviewsCollection = db.collection('reviews');

    const newReview = { username, review };
    await reviewsCollection.insertOne(newReview);
    client.close();
  } catch (err) {
    throw new Error('Error posting review: ' + err);
  }
}

module.exports = { postReview };
