package org.podcastpedia.core.user;

import org.podcastpedia.common.domain.*;

import java.util.List;
import java.util.Map;

public interface UserDao {

	/**
	 * Returns a list with all the podcasts the user, identified by username has subscribed to
	 *
	 * @param username
	 * @return
	 */
	public List<Podcast> getSubscriptions(String username);

	/**
	 * Returns a list with the latest episodes from a user, identified by userId, subscriptions
	 * ordered by the publication date DESC(endent)
	 *
	 * @param username - email of the user
	 * @return
	 */
	public List<Episode> getLatestEpisodesFromSubscriptions(String username);

    /**
     * Adds user to the database, but the status is not yet enabled.
     *
     * @param user
     */
    public void addUser(User user);

    /** returns an user given its username */
    public User getUserByUsername(String username);

    /** returns an user given its username and resetPasswordToken*/
    public User getUserByUsernameAndResetPasswordToken(User user);

    /**
     * Adds username and podcastId to the subscriptions table
     * @param params
     */
    void subscribeToPodcast(Map<String, Object> params);

    /**
     * Removes data entry from subscriptions table identified by username and podcastId
     * @param params
     */
    void unsubscribeFromPodcast(Map<String, Object> params);

    /** Inserts a new entry in the podcats_votes table */
    void addPodcastVote(PodcastVote vote);

    /** Inserts a new entry in the episodes_votes table */
    void addEpisodeVote(EpisodeVote episodeVote);

    /** sets the enabled flag to 1*/
    void enableUser(User user);

    /** adds the ROLE_USER to the table authorities for the @param user */
    void addUserRole(User user);

    /**
     * Generates a new registration-token to be used in password reactivation and sets the user
     * temporarily on disabled until she gets reactivated and changes her password
     *
     * @param user
     */
    void updateUserForPasswordReset(User user);

    void resetUserPassword(User user);

    /**
     * Returns the podcast from the selected playist
     *
     * @param params a map containing the email and the name of the subscription category
     * @return list of podcasts
     */
    List<Podcast> getPodcastsForSubscriptionCategory(Map<String, Object> params);

    List<String> getSubscriptionCategoriesForUser(String email);

    /**
     * Removes data entry from subscriptions table identified by username, podcastId and subscription category
     *
     * @param params (email, podcast id and subscription category)
     */
    void removeFromSubscriptionCategory(Map<String, Object> params);
}
