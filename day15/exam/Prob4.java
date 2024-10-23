package com.shinhan.day15.exam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 매개변수로 받은 Product 배열에서
 * 특정 금액 이상의 상품만 선택하여 HashSet에 저장하여 리턴하는 makeHashSet() 메쏘드와
 * 매개변수로 받은 HashSet의 정보를 data.txt 파일에 출력하는 makeFile() 메쏘드를 구현하시오.
 */

public class Prob4 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Product[] prodList = { new Product("NT450R5E-K24S", 500000, "삼성전자"),
				new Product("15UD340-LX2CK", 400000, "LG전자"),
				new Product("G2-K3T32AV", 600000, "HP") };
		HashSet<Product> product_hs = makeHashSet(prodList, 500000);
		makeFile(product_hs);
		readFile();
	}

	private static HashSet<Product> makeHashSet(Product[] prodList, int price) {
		HashSet<Product> hashSet = new HashSet<>();
		
		System.out.println("*특정 금액 이상의 상품 결과입니다.***************");
		for (Product p : prodList) {
			if (p.getPrice() >= price) {
				hashSet.add(p);
				System.out.println(p);
			}
		}
		System.out.println();

		return hashSet;
	}

	// 자바 => ObjectOutputStream(보조스트림) => FileOutputStream => 파일 aa.data
	private static void makeFile(HashSet resultList) throws IOException {
		FileOutputStream fos = new FileOutputStream("aa.data");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(resultList);
		
		oos.close();
		fos.close();
	}

	// 파일 aa.data => FileInputStream => ObjectInputStream(보조스트림) => 자바
	private static void readFile() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("aa.data");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		HashSet<Product> resultList = (HashSet<Product>) ois.readObject();
		
		System.out.println("*readFile 결과입니다.***************");
		for (Product p : resultList) {
			System.out.println(p);
		}
		
		ois.close();
		fis.close();
	}

}

class Product implements Serializable {
	private String model_name;
	private int price;
	private String company;

	public Product(String model_name, int price, String company) {
		super();
		this.model_name = model_name;
		this.price = price;
		this.company = company;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Product [model_name=" + model_name + ", price=" + price + ", company=" + company + "]";
	}

}