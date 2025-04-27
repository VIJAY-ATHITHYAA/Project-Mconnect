// server/controllers/reviewController.js
const { MongoClient } = require('mongodb');

// MongoDB connection setup
const url = process.env.MONGO_URI;
const dbName = 'mit_connect';

async function getAllReviews(req, res) {
  try {
    const client = await MongoClient.connect(url);
    const db = client.db(dbName);
    const reviewsCollection = db.collection('reviews');

    const reviews = await reviewsCollection.find().toArray();
    res.status(200).json(reviews);
  } catch (err) {
    res.status(500).json({ message: 'Server error', error: err });
  }
}

async function postReview(req, res) {
  const { username, review } = req.body;

  try {
    const client = await MongoClient.connect(url);
    const db = client.db(dbName);
    const reviewsCollection = db.collection('reviews');

    const newReview = { username, review };
    await reviewsCollection.insertOne(newReview);

    res.status(201).json({ message: 'Review posted successfully' });
  } catch (err) {
    res.status(500).json({ message: 'Server error', error: err });
  }
}

module.exports = { getAllReviews, postReview };
