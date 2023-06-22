package com.stackleader.netbeans.chatgpt;

/**
 *
 * @author dcnorris
 */
import static com.stackleader.netbeans.chatgpt.ChatTopComponent.QUICK_COPY_TEXT;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import javax.swing.event.HyperlinkEvent;
import javax.swing.text.BadLocationException;
import org.fife.ui.rsyntaxtextarea.*;

public class CodeBlockLinkGenerator implements LinkGenerator {

    System.Logger LOG = System.getLogger("CodeBlockLinkGenerator");
    private static final String TRIPLE_BACKTICK = "```";

    @Override
    public LinkGeneratorResult isLinkAtOffset(RSyntaxTextArea textArea, int offs) {
        try {
            int currentLine = textArea.getLineOfOffset(offs);
            int startOffset = textArea.getLineStartOffset(currentLine);
            int endOffset = textArea.getLineEndOffset(currentLine);
            String lineText = textArea.getText(startOffset, endOffset - startOffset);

            if (lineText.trim().startsWith(TRIPLE_BACKTICK) && lineText.contains(QUICK_COPY_TEXT)) {
                int lineCount = textArea.getLineCount();
                StringBuilder sb = new StringBuilder();
                for (int line = currentLine + 1; line < lineCount; line++) {
                    int lineStartOffset = textArea.getLineStartOffset(line);
                    int lineEndOffset = textArea.getLineEndOffset(line);
                    String currentLineText = textArea.getText(lineStartOffset, lineEndOffset - lineStartOffset);
                    if (currentLineText.trim().equals(TRIPLE_BACKTICK)) {
                        break;
                    } else {
                        sb.append(currentLineText);
                    }
                }
                return new LinkGeneratorResult() {
                    @Override
                    public HyperlinkEvent execute() {
                        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clipboard.setContents(new StringSelection(sb.toString()), null);
                        return null;
                    }

                    @Override
                    public int getSourceOffset() {
                        return offs;
                    }
                };
            }
        } catch (BadLocationException ex) {
            LOG.log(System.Logger.Level.ERROR, "CodeBlockLinkGenerator failed", ex);
        }
        return null;
    }

}
