package br.com.gabrieljony.pmhapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer request_id;

    private Integer type;

    private Long date;

    private String comments;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    public Request() {
    }

    public Request(Integer request_id, Integer type, Long date, String comments, Client client_id, User user_id) {
        this.request_id = request_id;
        this.type = type;
        this.date = date;
        this.comments = comments;
        this.client_id = client_id;
        this.user_id = user_id;
    }

    public Integer getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Integer request_id) {
        this.request_id = request_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Client getClient_id() {
        return client_id;
    }

    public void setClient_id(Client client_id) {
        this.client_id = client_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(request_id, request.request_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(request_id);
    }
}
