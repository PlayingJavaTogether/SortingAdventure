ДАНО
====

Имеется интерфейс SortingAlgorithm объявленный так:

 import java.util.ArrayList;
 public interface SortingAlgorithm {
     ArrayList<String> sort(ArrayList<String> listToSort);
 }

ЗАДАНИЕ
=======

1. Написать класс BubbleSorting, который реализует интерфейс SortingAlgorithm и
осуществляет сортировку, как написано тут https://ru.wikipedia.org/wiki/Сортировка_пузырьком

2. Написать класс QuickSorting, который реализует интерфейс SortingAlgorithm и
осуществляет сортировку, как написано тут https://ru.wikipedia.org/wiki/Быстрая_сортировка

3. Написать класс HeapSorting, который реализует интерфейс SortingAlgorithm и
осуществляет сортировку, как написано тут https://ru.wikipedia.org/wiki/Пирамидальная_сортировка

ДОПОЛНИТЕЛЬНО
=============

4. Написать Unit test для каждого из классов

5. Оценить сложность алгоритмов (в терминах O(n))