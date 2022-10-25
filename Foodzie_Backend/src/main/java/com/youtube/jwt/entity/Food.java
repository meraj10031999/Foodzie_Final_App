package com.youtube.jwt.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Food {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Price")
	private String price;
	
//	@Column(name="Tags")
//	private double tags;
	
		
	
	@Column(name="Favorite")
	private boolean favorite;
	
	@Column(name="CookTime")
	private int cookTime;
	
	@Column(name="Stars")
	private float stars;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "FOOD_IMAGE",
            joinColumns = {
                    @JoinColumn(name = "FOOD_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "IMAGE_ID")
            }
    )
    private Set <ImageModel> imageModel;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "FOOD_CART",
            joinColumns = {
                    @JoinColumn(name = "FOOD_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "CART_ID")
            }
    )
	private Cart cart;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "FOOD_CATAGORY",
            joinColumns = {
                    @JoinColumn(name = "FOOD_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "CATAGORY_ID")
            }
    )
	private Catagory catagory;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "FOOD_ORIGIN",
            joinColumns = {
                    @JoinColumn(name = "FOOD_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ORIGIN_ID")
            }
    )
    private Set<Origin> nation;

	public 
	Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public int getCookTime() {
		return cookTime;
	}

	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}

	public float getStars() {
		return stars;
	}

	public void setStars(float stars) {
		this.stars = stars;
	}

	public Set<ImageModel> getImageModel() {
		return imageModel;
	}

//	public void setImageModel(Set<ImageModel> imageModel) {
//	}
//
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Catagory getCatagory() {
		return catagory;
	}

	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}

	public Set<Origin> getNation() {
		return nation;
	}

	public void setNation(Set<Origin> nation) {
		this.nation = nation;
	}

	public void setImageModel(Set<ImageModel> images) {
		// TODO Auto-generated method stub
		this.imageModel = images;

		
	}

	
	
	
}
