/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitrunner;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.errors.NoWorkTreeException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

/**
 *
 * @author Sanket K<hckrtst@gmail.com>
 */
public class GitRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            // Run git status for fun using Process
            Process p = Runtime.getRuntime().exec("git status");
            
            BufferedReader reader;
            BufferedReader error_reader;
            
            reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            error_reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            
            
            String cmd_output = null;
            
            while((cmd_output = reader.readLine()) != null) {
                
                System.out.println(cmd_output);
            }
            
            while((cmd_output = error_reader.readLine()) != null) {
                System.out.println("Error: " + cmd_output);
            }
            
            // Now use Jgit to get "git status"
            
            System.out.println("\n\n ===== Using Jgit =====");
            FileRepositoryBuilder builder = new FileRepositoryBuilder();
            
            Repository repo = builder
                    .readEnvironment()
                    .findGitDir()
                    .build();
            
            
            if (repo == null) {
                System.err.println("No repo");
            } else {
                System.out.println("Got repo");
            }
            
            Git git = new Git(repo);
            
            Status status = null;
            try {
                status = git.status().call();
            } catch (GitAPIException ex) {
                Logger.getLogger(GitRunner.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-1);
            } catch (NoWorkTreeException ex) {
                Logger.getLogger(GitRunner.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-1);
            }
            
            Set<String> result = new HashSet<>();
            
            System.out.println("Untracked = " + status.getUntracked());
            result.addAll(status.getModified());
            result.addAll(status.getAdded());
            result.addAll(status.getUntracked());
            System.out.println(result.toString());
            
        } catch (IOException ex) {
            Logger.getLogger(GitRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
