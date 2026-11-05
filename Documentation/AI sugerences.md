# AI Suggestions (This is just AI feedback not required)

Suggestions for improving Accounting Ledger and preparing your presentation. This document collects observations and ideas for you to develop yourself; it contains no code or completed implementation.

## Starting point

You already have a functional foundation: menu navigation, transaction loading, transaction listings, date reports, and custom search. During the latest review, custom search displayed matches correctly, rejected reversed date ranges, and handled optional fields.

For tomorrow, the biggest opportunity is to make those features easy to understand and visually consistent in the terminal.

## Priority 1: the most noticeable CLI improvements

### Identity and visual hierarchy

- [ ] Choose a visible application name and use it on the home screen.
- [ ] Visually distinguish the screen title, menu options, and input prompt.
- [ ] Keep widths, spacing, and separator styles consistent across menus.
- [ ] Use blank space to separate sections while avoiding crowded text or unnecessarily long screens.
- [ ] Use consistent language and capitalization for titles, options, and messages.

The goal: someone should understand where they are and what they can do without needing your explanation.

### Transaction listings

Transactions currently appear as lines separated by `|`, closely resembling the file format. Consider a presentation that is easier to scan:

- [ ] Clear headers for date, time, description, vendor, and amount.
- [ ] Aligned columns, with amounts aligned to the right and displayed with two decimal places.
- [ ] Visual separation between headers, rows, and the summary.
- [ ] A consistent way to handle long descriptions or vendor names without disrupting the table.
- [ ] Recognizable differences between deposits and payments, while preserving the amount's sign.
- [ ] A count of displayed transactions at the end of the listing.

Check that the output is readable in a normal terminal window without requiring full screen.

### Navigation and messages

- [ ] Make returning to the previous menu and returning home clear on every screen.
- [ ] Give a brief explanation after an invalid selection; the letter menus currently prompt again without explaining the error.
- [ ] Consider a pause after results so the next menu does not draw attention away from them.
- [ ] Show a clear confirmation after saving a deposit or payment, only when the operation has completed successfully.
- [ ] Use a consistent style for success messages, errors, and empty results.

## Priority 2: details that would make the experience more complete

| Area          | Idea to consider                                                         | Benefit                                    |
| ------------- | ------------------------------------------------------------------------ | ------------------------------------------ |
| Home          | Separate the balance from the menu options                               | Makes the main figure stand out            |
| Reports       | Show the report name and the period being queried                        | Explains what the rows represent           |
| Custom search | Summarize the filters used                                               | Helps users interpret the results          |
| Empty results | Explain that nothing matched and suggest adjusting the filters           | Keeps the screen from feeling incomplete   |
| Summary       | Show income, expenses, and the net amount for the displayed transactions | Provides context without reading every row |
| Long listings | Consider pagination if time allows                                       | Reduces terminal scrolling                 |

If you add totals, clearly distinguish the overall balance from the result of a search or report.

### Color and decoration as supporting details

- [ ] Consider a small palette: one main color, one for success, and one for errors.
- [ ] Keep labels and signs; color alone should not carry meaning.
- [ ] Test colors and special symbols in the terminal you will use for the presentation.
- [ ] Prefer subtle, readable borders; treat large drawings and animations as optional extras with low priority.

A well-aligned table and clear messages will contribute more to the presentation than extensive decoration.

## Program improvements still worth reviewing

These points deserve attention, but separate small adjustments from changes that could consume the entire day:

- **Whitespace in input:** the basic vendor search does not find ` Adobe `, although it finds `Adobe`. Required text fields also accept input made up entirely of spaces.
- **Special numeric values:** during the review, `NaN` was accepted as a search amount. Review which inputs should count as valid amounts throughout the application.
- **Persistence and precision:** check that a newly entered amount matches what is displayed and what is loaded after restarting, especially when more than two decimal places are entered.
- **Demo data:** the CSV mixes realistic transactions with test entries containing enormous amounts. Prepare a demo dataset that is easy to explain, keeping a copy of any data you want to preserve.
- **Duplication:** deposits and payments share substantial logic. This is a maintenance opportunity after the demo is reliable.
- **Code readability:** review indentation, incomplete comments, commented-out code, and unused imports.
- **Documentation:** consider a short README covering the purpose, run instructions, and available features.

## Preparing the presentation

### Suggested flow for a short demo

1. Explain the problem the program solves and who would use it.
2. Show the home screen and balance.
3. Record a simple transaction and locate it in the ledger.
4. Show a report with data available for the selected period.
5. Run a custom search with a few filters and a known result.
6. Briefly demonstrate input validation or a search with no matches.
7. Describe one technical lesson learned and one remaining improvement.

Adapt the flow to your available time and assignment rubric. You do not need to visit every option to demonstrate that you understand the project.

### Topics worth explaining in your own words

- Each class's responsibility.
- How transactions move from the file to the list and from the list to the screen.
- How you distinguish deposits from payments.
- How you combine optional search filters.
- The difference between invalid input and a valid search with no results.
- What you tested and which limitations you know about.

### Checks before presenting

- [ ] Adjust font size and contrast so the audience can read the terminal.
- [ ] Rehearse the complete flow in the same terminal you will use to present.
- [ ] Know the data and filters you will use for each example.
- [ ] Verify that you can save a transaction, close the app, reopen it, and find that transaction.
- [ ] Check that reports based on the current date have data to display.
- [ ] Plan how to recover your demo flow if you mistype an input.
- [ ] Know how to run the project from its directory.

## How to prioritize tomorrow

1. **First:** consistent titles, spacing, tables, and messages.
2. **Next:** small validation improvements and suitable demo data.
3. **Then:** rehearse and verify the complete presentation flow.
4. **If time allows:** colors, summaries, and other visual extras.

Avoid starting a major code reorganization immediately before presenting. Aim for a clear experience and a demo you can explain confidently.
