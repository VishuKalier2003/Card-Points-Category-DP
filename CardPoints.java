/* There are several cards arranged in a row, and each card has an associated number of points. The points are 
given in the integer array cardPoints... In one step, you can take one card from the beginning or from the end of 
the row. You have to take exactly k cards... Your score is the sum of the points of the cards you have taken...
Given the integer array cardPoints and the integer k, return the maximum score you can obtain...
* Eg 1 :  cards = [1,2,3,4,5,6,1]       k = 3                 Output = 1 + 6 + 5 = 12
* Eg 2 :  cards = [2,2,2]               k = 2                 Output = 2 + 2 = 4
* Eg 3 :  cards = [9,7,7,9,7,7,9]       k = 7                 Output = 9 + 7 + 7 + 9 + 7 + 7 + 9 = 55
*/
import java.util.*;
public class CardPoints
{
      public int MaxPoints(int points[], int draws)
      {     // Using Two Pointers to check both the sides...
            int i = draws - 1, j = points.length - draws;     //*  Variable => O(1)
            int score = 0;
            while(i >= 0)       //! Comparison => O(N)
            {
                  int max = Math.max(points[i], points[j]);   // Maximum of the two given at same depth...
                  score = score + max;
                  i--;     // Moving the left pointer towards left...
                  j++;     // Moving the right pointer towards right...
            }
            return score;      // Returning the Maximum Score...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter number of Cards in the Array : ");
            x = sc.nextInt();
            int card[] = new int[x];
            for(int i = 0; i < card.length; i++)
            {
                  System.out.print("Enter point of "+(i+1)+" th card : ");
                  card[i] = sc.nextInt();
            }
            System.out.print("Enter number of Cards that can be drawn (k) : ");
            x = sc.nextInt();
            CardPoints cardpoints = new CardPoints();             // Object creation...
            System.out.print("The Maximum Possible Score : "+cardpoints.MaxPoints(card, x));
            sc.close();
      }
}



//! Time Complexity => O(N)
//* Space Complexity => O(1)

/** //? DEDUCTIONS :-
 * ? We compare the points which are equidepth from left say (3 index away) and right say (3 index away)...
 * ? The greater number at each depth is added at the score...
 * ? Since for every move, we can either choose card at left or right, we start from bottom and maximise the score
 * ? to top...
 */