Иван Павлов - бр.индекс 135016
Control Flow Graph
![SI_Lab_2_CFG](https://github.com/user-attachments/assets/6c7105d7-b691-455e-9704-d6e7d33de273)

Цикломатска комплексност

V(G) = P + 1 = 8 + 1 = 9
Цикломатската комплексност на овој код е 9, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=8 (6 - IF, 2 - For ), па цикломатската комплексност изнесува 9.

Тест случаи според критериумот Every statement

За успешно да стигнеме до сите јазли потребно е минимум еднаш да ги поминеме сите услови (IF јазли). Поради ова минималниот број на тестови ќе биде 6 и тоа:
  1. Null items list
  2. Valid item, with discount
  3. Valid item, no discount
  4. Invalid item name
  5. Invalid char in card
  6. Invalid card length

Тест случаи според критериумот Multiple Conditions за if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)

За успешно да ги опфатиме сите услови според критериумот Multiple Conditions потребно е да ги опфатиме сите сценарија за секој од условите. Бидејќи имаме 3 различни услови, сите сценарија ќе може да ги опфатиме со 8 тестови
000 F,F,F - > F
001 F,F,T - > T
010 F,T,F - > T
011 F,T,T - > T
100 T,F,F - > T
101 T,F,T - > T
110 T,T,F - > T
111 T,T,T - > T

