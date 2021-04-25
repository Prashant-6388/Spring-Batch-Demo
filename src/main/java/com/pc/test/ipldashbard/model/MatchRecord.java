package com.pc.test.ipldashbard.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class MatchRecord {
    @Id
    private Long id;
    private String city;
    private LocalDate date;
    private String playerOfMatch;
    private String venue;
    private String team1;
    private String team2;
    private String tossWinner;
    private String tossDecision;
    private String winner;
    private String result;
    private String resultMargin;
    private boolean eliminator;
    private String method;

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return LocalDate return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * @return String return the playerOfMatch
     */
    public String getPlayerOfMatch() {
        return playerOfMatch;
    }

    /**
     * @param playerOfMatch the playerOfMatch to set
     */
    public void setPlayerOfMatch(String playerOfMatch) {
        this.playerOfMatch = playerOfMatch;
    }

    /**
     * @return String return the venue
     */
    public String getVenue() {
        return venue;
    }

    /**
     * @param venue the venue to set
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     * @return String return the team1
     */
    public String getTeam1() {
        return team1;
    }

    /**
     * @param team1 the team1 to set
     */
    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    /**
     * @return String return the team2
     */
    public String getTeam2() {
        return team2;
    }

    /**
     * @param team2 the team2 to set
     */
    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    /**
     * @return String return the tossWinner
     */
    public String getTossWinner() {
        return tossWinner;
    }

    /**
     * @param tossWinner the tossWinner to set
     */
    public void setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
    }

    /**
     * @return String return the tossDecision
     */
    public String getTossDecision() {
        return tossDecision;
    }

    /**
     * @param tossDecision the tossDecision to set
     */
    public void setTossDecision(String tossDecision) {
        this.tossDecision = tossDecision;
    }

    /**
     * @return String return the winner
     */
    public String getWinner() {
        return winner;
    }

    /**
     * @param winner the winner to set
     */
    public void setWinner(String winner) {
        this.winner = winner;
    }

    /**
     * @return String return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return String return the resultMargin
     */
    public String getResultMargin() {
        return resultMargin;
    }

    /**
     * @param resultMargin the resultMargin to set
     */
    public void setResultMargin(String resultMargin) {
        this.resultMargin = resultMargin;
    }

    /**
     * @return boolean return the eliminator
     */
    public boolean isEliminator() {
        return eliminator;
    }

    /**
     * @param eliminator the eliminator to set
     */
    public void setEliminator(boolean eliminator) {
        this.eliminator = eliminator;
    }

    /**
     * @return String return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method the method to set
     */
    public void setMethod(String method) {
        this.method = method;
    }

}
