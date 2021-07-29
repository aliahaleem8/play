/*

given string  = "facebook"
reverse all vowels within string

return "focobeak"
FB
- System design interview goal: assess your system design skills
- Some questions are huge, although you can go superficial, talk to interviewer to narrow scope
- YOU drive the discussion. Start small, ask questions so you understand scope, then go. Interviewer will turn you if you go the wrong way. e.g. you will use relational DB but interviewer will ask something else instead
- candidates don’t need to be super knowledgable on all aspects. You could spend time in a specific area, like back-end, because you like back-end; ask questions like “is this what you’re looking for, are ou looking for more details in this aspect, etc.” to manage your time better
- *it’s always about trade-offs* - evaluate trade-offs. They want to see that.
- ruling out what approaches doesn’t work, demonstrates good knowledge too.
- if you think solution is working or not solution, ask interviewer, keep going
-

Have a structured approach.

Good candidate:
Understand question/clarify requirements
SD sounds huge, not expected in 45 to do all E2E.
Crucial to understand question. Ask more questions. Clarify to narrow down scope of requirements.


Start going through blogs of system design interviews…


Coding,
Coding,
Product Architecture,
Behavioral
Coding


System D —> focus on infrastruction of solution, looking for details on scale/infrastructure.

Product design —> product aspect of system, data model, api, specific system your using for product.

How important is back of envelop calculation ?

Establish that your thinking of a solution; comeup with your assumption/estimations/ initially. Interviewer may help you later …


Jagadeesh Yerrapati


Basically confirm before solving a specific area by clarifying;
Confirm before moving onto another aspect
Give an example of product/system

Trade-offs which one to pick?
No right and wrong; as long as you can explain why you choose it and are able to explain it to them.

I think I would use this b/c of abc; it fits better b/c of having these capabilities that are precedence for our design/prodcut. It demonstrates your system knowledge.


—

Love learning /understanding… limited by current job duties.
Once tasked with something, I accomplish it.

Real world solutions involves investigation / research collaboration.
Interviews eliminates research aspect.


Broader aspect only being looked at…

——

You drive discussion in system design interview. Trying to get structure.
Your responsible for structure conversation end to end, etc.


dino08@fb.com

Survey




 */

public class FB_Interview_Q1 {


    // utility function to check for vowel
    static boolean isVowel(char c) {
        return (c == 'a' || c == 'A' || c == 'e'
                || c == 'E' || c == 'i' || c == 'I'
                || c == 'o' || c == 'O' || c == 'u'
                || c == 'U');
    }


}
