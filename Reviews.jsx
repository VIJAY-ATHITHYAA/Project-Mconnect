// client/src/components/Reviews.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Reviews() {
  const [reviewText, setReviewText] = useState('');
  const [reviews, setReviews] = useState([]);
  const [error, setError] = useState('');

  // Fetch reviews on component mount
  const fetchReviews = async () => {
    try {
      const response = await axios.get('http://localhost:5000/api/reviews');
      setReviews(response.data);
    } catch (err) {
      setError('Failed to fetch reviews');
    }
  };

  useEffect(() => {
    fetchReviews();
  }, []);

  // Handle posting a new review
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const newReview = { reviewText };
      await axios.post('http://localhost:5000/api/reviews', newReview);
      setReviewText(''); // Reset input after posting
      fetchReviews(); // Fetch reviews again to show the updated list
    } catch (err) {
      setError('Failed to post review');
    }
  };

  return (
    <div>
      <h2>Post a Review</h2>
      {error && <p>{error}</p>}
      <form onSubmit={handleSubmit}>
        <textarea
          value={reviewText}
          onChange={(e) => setReviewText(e.target.value)}
          placeholder="Write your review here"
          required
        />
        <button type="submit">Submit Review</button>
      </form>

      <h3>All Reviews:</h3>
      <ul>
        {reviews.map((review, index) => (
          <li key={index}>{review.reviewText}</li>
        ))}
      </ul>
    </div>
  );
}

export default Reviews;
