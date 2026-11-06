# Pledger — Presentation Cue Sheet

**Follow the steps. Explain them in your own words.** Leave the last 90 seconds for questions.

## Before you start

Have the app running, [the diagram](pledger-flow.svg) open, and [`Report.java`](../src/main/java/com/pluralsight/Report.java) ready at `customSearch()`. Make the terminal text big enough to read.

## 0:00–1:00 · Introduction

“Pledger is a Java app for tracking money coming in and going out. I'll show how to record transactions, find them, and how my custom search works.”

Show the diagram briefly: **load file → Home → Ledger → Reports**.

## 1:00–4:00 · Show the app

1. **Home → D:** add a deposit.
   - Description: `Demo consulting`
   - Vendor: `Demo Client`
   - Amount: try `abc`, then `0`, then `100`.
   - Point out: invalid amounts are rejected; the balance goes up.
2. **Home → P:** make a payment.
   - Description: `Demo supplies`
   - Vendor: `Demo Store`
   - Amount: `25`.
   - Point out: payments are stored as negative amounts. Your balance is now **$75 higher than when you started**.
3. **Home → L → A:** show both transactions, newest first.
4. In Ledger, choose **D**, then **P**, to show the separate lists.

## 4:00–5:30 · Reports and search

From Ledger, choose **R**:

- **1:** show Month to date. The two new transactions should appear.
- **5:** search for `Adobe`.
- **6:** try Custom Search:

| Field | Enter |
| --- | --- |
| Start date | Press Enter |
| End date | Press Enter |
| Description | `software` |
| Vendor | `adob` |
| Amount | `-54.99` |

Point out: **blank fields are skipped, partial text works, and every filter must match.**

If time allows, try another custom search: start `2026-11-02`, end `2026-11-01`, and skip the rest. Show that the reversed dates are rejected.

## 5:30–7:30 · Show your code

Open **Report.java → customSearch()**. Point to these three things:

1. **Optional fields:** empty fields don't restrict the search.
2. **`matches`:** starts as `true`; a failed filter makes it `false`.
3. **`if (matches)`:** only matching transactions enter the results list.

Example explanation: “A transaction might match Adobe but have the wrong amount. It has to match both to appear. The search builds a separate list, so it doesn't change the ledger.”

## 7:30–8:30 · Finish

- Return with **0 → H → X**, then run the app again.
- Show that the balance and your two transactions are still there.
- Mention one improvement: **“I'd use BigDecimal to handle money more precisely.”**
- “That's Pledger. Any questions?”

## 8:30–10:00 · Questions

Repeat the question out loud, then answer simply.

- **Why a file?** Simple storage that survives restarting.
- **Deposits vs. payments?** Positive vs. negative amounts.
- **All search fields blank?** All transactions are returned.

**If you're behind:** skip the extra date example and shorten the report tour. Still show your code.
