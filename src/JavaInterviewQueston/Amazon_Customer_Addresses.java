package JavaInterviewQueston;

public class Amazon_Customer_Addresses {

	public interface ICustomer{
		
	}
	
	public interface ICustomerAddress{
 
	}
	
	public class Customer implements ICustomer{
		
//		@Id
//	    @GeneratedValue(strategy = GenerationType.AUTO)
//		private Long id;
//		
//		.....
		
		
	}
	
	public class BillingCustomerAddress implements ICustomerAddress{
//		@Id
//	    @GeneratedValue(strategy = GenerationType.AUTO)
//		private Long id;
//		
//		.....
	}
	
	public class ShippingCustomerAddress implements ICustomerAddress{
//		@Id
//	    @GeneratedValue(strategy = GenerationType.AUTO)
//		private Long id;
//		
//		.....
	}
	
//	One Customer might have many customer addresses and
//	One Customer addresses might belong to many customers
//	so they have a many-to-many association.
	
	public interface ICustomerAddressService{
		
		public void create(ICustomerAddress customerAddress);
		public ICustomerAddress read(Long customerAddressId);		
		public void update(ICustomerAddress customerAddress);
		public void delete(Long customerAddressId); 
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
//	public interface IMaintainable : IDisposable

}


