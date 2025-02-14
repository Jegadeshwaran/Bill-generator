package BillGeneratorApplication;

import java.util.Scanner;

public class Customer {
		private String name;
		private String phoneNo;
		private String serviceType;
		Scanner sc = new Scanner(System.in);
		
		Customer(){
			setName();
			setPhoneNo();
			setServiceType();
		}

		public String getServiceType() {
			return serviceType;
		}

		public void setServiceType() {
			while(true) {
				System.out.println("DineIn or TakeAway D or T");
				char sT = sc.nextLine().charAt(0);
				if(sT == 'D' || sT == 'd' || sT=='T' || sT=='t') {
					if(sT == 'D' || sT == 'd') {
						serviceType = "Dine In";
					}
					else {
						serviceType = "Take away";
					}
					break;
				}
				else {
					System.out.println("Enter a valid input");
				}
			}
		}

		public String getName() {
			return name;
		}

		public void setName() {
			System.out.println("Enter the Customer Name:");
			name = sc.nextLine();
		}

		public String getPhoneNo() {
			return phoneNo;
		}

		public void setPhoneNo() {
			while(true)
			{
			      System.out.print("Enter your PhoneNumber: ");
			      this.phoneNo = sc.nextLine();
			      if (phoneNo.matches("\\d{10}"))
			      {
			        break;
			      }
			      else
			      {
			        System.out.println("Enter a valid input");
			      }
			}
		}
		
}
