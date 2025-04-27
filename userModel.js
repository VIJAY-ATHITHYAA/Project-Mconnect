// server/models/userModel.js
const { MongoClient } = require('mongodb');
const bcrypt = require('bcryptjs');

// MongoDB connection setup
const url = process.env.MONGO_URI;
const dbName = 'mit_connect';

async function createUser(username, email, password) {
  try {
    const client = await MongoClient.connect(url);
    const db = client.db(dbName);
    const usersCollection = db.collection('users');

    const hashedPassword = await bcrypt.hash(password, 10);
    const newUser = { username, email, password: hashedPassword };

    await usersCollection.insertOne(newUser);
    client.close();
  } catch (err) {
    throw new Error('Error creating user: ' + err);
  }
}

module.exports = { createUser };
