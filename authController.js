
// server/controllers/authController.js
const { MongoClient } = require('mongodb');
const bcrypt = require('bcryptjs');

// MongoDB connection setup
const url = process.env.MONGO_URI;
const dbName = 'mit_connect';

async function login(req, res) {
  const { email, password } = req.body;

  try {
    const client = await MongoClient.connect(url);
    const db = client.db(dbName);
    const usersCollection = db.collection('users');

    // Check if user exists
    const user = await usersCollection.findOne({ email });
    if (!user) return res.status(400).json({ message: 'User not found' });

    // Compare passwords
    const match = await bcrypt.compare(password, user.password);
    if (!match) return res.status(400).json({ message: 'Invalid credentials' });

    res.status(200).json({ message: 'Login successful' });
  } catch (err) {
    res.status(500).json({ message: 'Server error', error: err });
  }
}

module.exports = { login };
