package services;

import models.Review;
import java.util.List;
import java.util.ArrayList;

public class ReviewService {
    private List<Review> recenzii = new ArrayList<>();

    public boolean addReview(Review review) {
        recenzii.add(review);
        return true;
    }

    public List<Review> getReviewsForField(int fieldId) {
        List<Review> fieldReviews = new ArrayList<>();
        for (Review rev : recenzii) {
            if (rev.getTerenId() == fieldId) {
                fieldReviews.add(rev);
            }
        }
        return fieldReviews;
    }

    public double calculateAverageRating(int fieldId) {
        List<Review> fieldReviews = getReviewsForField(fieldId);
        if (fieldReviews.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Review review : fieldReviews) {
            sum += review.getRating();
        }
        return sum / fieldReviews.size();
    }
}
