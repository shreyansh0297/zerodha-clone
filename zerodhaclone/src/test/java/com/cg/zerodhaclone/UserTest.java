package com.cg.zerodhaclone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cg.zerodhaclone.entities.Trader;
import com.cg.zerodhaclone.repository.ITraderRepository;
import com.cg.zerodhaclone.service.TraderServiceImpl;
import com.cg.zerodhaclone.service.UserServiceImpl;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTest {
	
	@Mock
	private ITraderRepository traderRepo;

	@InjectMocks
	private UserServiceImpl userService;

	@BeforeEach
	void setUp() throws Exception
	{
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void UserSignInTest() {

		Trader trader = new Trader();
		trader.setEmailId("rise@gmail.com");
		trader.setPassword("1758");

		Mockito.when(traderRepo.findByEmailIdAndPassword("rise@gmail.com", "1758"))
		.thenReturn(trader);
		assertEquals(trader,userService.signOut("rise@gmail.com","1758"));

	}
	
//	@Test
//	public void UserSignOutTest() {
//		
//		Trader trader = new Trader();
//		trader.setEmailId("rise@gmail.com");
//		trader.setPassword("1758");
//
//		Mockito.when(traderRepo.findByEmailIdAndPassword("rise@gmail.com", "1758"))
//		.thenReturn(trader);
//		assertEquals(trader,userService.signOut("rise@gmail.com","1758"));
//	}
}
