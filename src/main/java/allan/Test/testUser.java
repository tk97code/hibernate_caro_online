package allan.Test;

import jakarta.persistence.*;

@Entity
@Table (name = "player")
public class testUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String email;
    @Column
    String password;
    @Column
    String avatar;
    @Column
    String name;
    @Column
    String gender;
    @Column
    int yearOfBirth;
    @Column
    int score = 0; // gia tri mac dinh
    @Column
    int matchCount = 0;
    @Column
    int winCount = 0;
    @Column
    int loseCount = 0;
    @Column
    int currentStreak = 0; // số âm là chuỗi thua, dương là chuỗi thắng
    @Column
    boolean blocked = false;

    public testUser() {

    }

    public void addScore(int toAdd) {
        this.score += toAdd;
    }

    public testUser(String email, String password, String avatar, String name, String gender, int yearOfBirth, int score, int matchCount, int winCount, int loseCount, int currentStreak, boolean blocked) {
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.name = name;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.score = score;
        this.matchCount = matchCount;
        this.winCount = winCount;
        this.loseCount = loseCount;
        this.currentStreak = currentStreak;
        this.blocked = blocked;
    }

    public testUser(int id, String email, String password, String avatar, String name, String gender, int yearOfBirth, int score, int matchCount, int winCount, int loseCount, int currentStreak, boolean blocked) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.name = name;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.score = score;
        this.matchCount = matchCount;
        this.winCount = winCount;
        this.loseCount = loseCount;
        this.currentStreak = currentStreak;
        this.blocked = blocked;
    }

    public testUser(String email, String password, String avatar, String name, String gender, int yearOfBirth) {
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.name = name;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
    }

    public testUser(testUser p) {
        this.id = p.id;
        this.email = p.email;
        this.password = p.password;
        this.avatar = p.avatar;
        this.name = p.name;
        this.gender = p.gender;
        this.yearOfBirth = p.yearOfBirth;
        this.score = p.score;
        this.matchCount = p.matchCount;
        this.winCount = p.winCount;
        this.loseCount = p.loseCount;
        this.currentStreak = p.currentStreak;
        this.blocked = p.blocked;
    }

    public int calculateTieCount() {
        return matchCount - winCount - loseCount;
    }

    public float calculateWinRate() {
        if (this.matchCount == 0) {
            return 0;
        }

        return (float) (100.0 * winCount / matchCount);
    }

    public String getNameId() {
        return name + " #" + id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public void setLoseCount(int loseCount) {
        this.loseCount = loseCount;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

}

