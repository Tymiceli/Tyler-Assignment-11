package com.codercampus.Assignment11.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository txnRepo;

	public List<Transaction> findAllByDate() {
		List<Transaction> txns = txnRepo.findAll();
		Collections.sort(txns, new Comparator<Transaction>() {

			@Override
			public int compare(Transaction o1, Transaction o2) {
				return o1.getDate().compareTo(o2.getDate());
			}

		});
		return txns;
	}

	public Transaction findById(Long txnId) {

		Optional<Transaction> txnFoundById = txnRepo.findAll().stream().filter(txn -> txn.getId().equals(txnId)).findAny();
		

		return txnFoundById.orElse(null);
	}

}
